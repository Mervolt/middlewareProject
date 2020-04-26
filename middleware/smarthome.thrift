namespace java gen.rpc.thrift
namespace py pygen.rpc.thrift

service Device {
  DeviceState getState(1: string id)
  Status turnOn(1: string id)
  Status turnOff(1: string id)
}

enum DeviceState {
  ON,
  OFF,
  DAMAGE
}

enum ResultCode {
  SUCCESS,
  ERROR
}

struct Status {
  1: ResultCode result,
  2: string message
}

struct AngularPosition{
  1: i32 vertivalAngle,
  2: i32 horizontalAngle
}

struct FridgeState{
  1: i32 temperature,
  2: bool isFreezing
}

struct DeviceObject {
  1: string id,
  2: DeviceState state
}

struct FridgeObject {
  1: DeviceObject device
  2: FridgeState fridgeState
}

struct CameraObject {
  1: DeviceObject device,
  2: i32 zoom,
  3: AngularPosition position
}

struct TemperatureSensorObject {
  1: DeviceObject device,
  2: i32 temperature,
  3: i32 alarmValue
}

exception InvalidArguments {
  1: string operation,
  2: string reason
}

service Fridge extends Device {
  Status startFreezing(1: string id)
  Status stopFreezing(1: string id)
  Status changeTemperatureTo(1: string id, 2: i32 value)
  FridgeState getTemperatureAndIsFreezing(1: string id)  
}

service TemperatureSensor extends Device {
  Status changeAlarmTemperatureValue(1: string id, 2: i32 alarmValue)
  i32 getTemperature(1: string id)
}

service Camera extends Device {
  Status moveToPositionAndZoom(1: string id, 2: AngularPosition position, 3: i32 value)
}