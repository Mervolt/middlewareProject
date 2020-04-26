namespace java gen.rpc.thrift
namespace py pygen

exception InvalidArguments {
  1: string operation,
  2: string reason
}

service Device {
  DeviceState getState(1: string id) throws (1: InvalidArguments invalidArgs)
  Status turnOn(1: string id) throws (1: InvalidArguments invalidArgs)
  Status turnOff(1: string id) throws (1: InvalidArguments invalidArgs)
  list <string> getEveryDevice()
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

service Fridge extends Device {
  Status startFreezing(1: string id) throws (1: InvalidArguments invalidArgs)
  Status stopFreezing(1: string id) throws (1: InvalidArguments invalidArgs)
  Status changeTemperatureTo(1: string id, 2: i32 value) throws (1: InvalidArguments invalidArgs)
  FridgeState getTemperatureAndIsFreezing(1: string id) throws (1: InvalidArguments invalidArgs)
}

service TemperatureSensor extends Device {
  Status changeAlarmTemperatureValue(1: string id, 2: i32 alarmValue) throws (1: InvalidArguments invalidArgs)
  i32 getTemperature(1: string id) throws (1: InvalidArguments invalidArgs)
}

service Camera extends Device {
  Status moveToPositionAndZoom(1: string id, 2: AngularPosition position, 3: i32 value) throws (1: InvalidArguments invalidArgs)
}
