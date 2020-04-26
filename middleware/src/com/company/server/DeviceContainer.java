package com.company.server;

import gen.rpc.thrift.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeviceContainer {
    List<FridgeObject> fridges = new ArrayList<>();
    List<CameraObject> cameras = new ArrayList<>();
    List<TemperatureSensorObject> sensors = new ArrayList<>();
    Random random = new Random();

    public DeviceContainer() {
    }

    public FridgeObject getFridgeById(String id){
        for(FridgeObject fridge: fridges) {
            if (fridge.getDevice().getId().equals(id))
                return fridge;
        }
        return null;
    }

    public CameraObject getCameraById(String id){
        for(CameraObject camera: cameras) {
            if (camera.getDevice().getId().equals(id))
                return camera;
        }
        return null;
    }

    public TemperatureSensorObject getSensorById(String id){
        for(TemperatureSensorObject sensor: sensors) {
            if (sensor.getDevice().getId().equals(id))
                return sensor;
        }
        return null;
    }

    protected void generateDevices(){
        for(int i = 0; i < SmartHomeServer.devicesAmount; i++){
            int deviceTypeGen = random.nextInt(3);
            DeviceObject deviceObject = generateDevice();
            switch(deviceTypeGen){
                case 0:
                    deviceObject.setId(generateFridgeId());
                    FridgeObject fridgeObject = generateFridge();
                    fridgeObject.setDevice(deviceObject);
                    this.fridges.add(fridgeObject);
                    break;
                case 1:
                    deviceObject.setId(generateCameraId());
                    CameraObject cameraObject = generateCamera();
                    cameraObject.setDevice(deviceObject);
                    this.cameras.add(cameraObject);
                    break;
                case 2:
                    deviceObject.setId(generateTemperatureSensorId());
                    TemperatureSensorObject temperatureSensorObject = generateTemperatureSensor();
                    temperatureSensorObject.setDevice(deviceObject);
                    this.sensors.add(temperatureSensorObject);
                    break;
            }
        }
    }

    private DeviceObject generateDevice() {
        Random random = new Random();
        DeviceObject deviceObject = new DeviceObject();
        int deviceStateGen = random.nextInt(3);
        deviceObject.setId("");
        switch (deviceStateGen) {
            case 0:
                deviceObject.setState(DeviceState.ON);
                break;
            case 1:
                deviceObject.setState(DeviceState.OFF);
                break;
            case 2:
                deviceObject.setState(DeviceState.DAMAGE);
                break;
        }
        return deviceObject;
    }

    private String generateFridgeId(){
        int nextId = this.fridges.size();
        return "fridge-" + nextId;
    }

    private String generateCameraId(){
        int nextId = this.cameras.size();
        return "camera-" + nextId;
    }

    private String generateTemperatureSensorId(){
        int nextId = this.sensors.size();
        return "sensor-" + nextId;
    }

    private FridgeObject generateFridge(){
        int isFreezingInt = random.nextInt(2);
        boolean isFreezing = isFreezingInt == 0;
        int temperature = random.nextInt(20) - 10;
        FridgeObject fridgeObject = new FridgeObject();
        FridgeState fridgeState = new FridgeState();
        fridgeState.setIsFreezing(isFreezing);
        fridgeState.setTemperature(temperature);
        fridgeObject.setFridgeState(fridgeState);
        return fridgeObject;
    }

    private CameraObject generateCamera(){
        int zoom = random.nextInt(65);
        int verticalAngle360 = random.nextInt(360);
        int horizontalAngle360 = random.nextInt(360);
        CameraObject cameraObject = new CameraObject();
        AngularPosition angularPosition = new AngularPosition();
        angularPosition.setHorizontalAngle(horizontalAngle360 - 180);
        angularPosition.setVertivalAngle(verticalAngle360 - 180);
        cameraObject.setPosition(angularPosition);
        cameraObject.setZoom(zoom);
        return cameraObject;
    }

    private TemperatureSensorObject generateTemperatureSensor(){
        TemperatureSensorObject temperatureSensorObject = new TemperatureSensorObject();
        int alarmValue = random.nextInt(100);
        int temperatureValue = random.nextInt(40);
        temperatureSensorObject.setAlarmValue(alarmValue);
        temperatureSensorObject.setTemperature(temperatureValue);
        return temperatureSensorObject;
    }
}
