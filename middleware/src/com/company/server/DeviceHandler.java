package com.company.server;

import gen.rpc.thrift.*;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class DeviceHandler implements Device.Iface {
    DeviceContainer deviceContainer;

    public DeviceHandler(DeviceContainer deviceContainer) {
        this.deviceContainer = deviceContainer;
    }

    @Override
    public DeviceState getState(String id) throws TException {
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        CameraObject camera = deviceContainer.getCameraById(id);
        TemperatureSensorObject sensor = deviceContainer.getSensorById(id);
        if(fridge !=null)
            return fridge.getDevice().getState();
        else if(camera != null)
            return camera.getDevice().getState();
        else if(sensor != null)
            return sensor.getDevice().getState();
        else
            throw new InvalidArguments("Get State ", "Device with id " + id + " does not exist");
    }

    @Override
    public Status turnOn(String id) throws TException {
        Status status = new Status();
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        CameraObject camera = deviceContainer.getCameraById(id);
        TemperatureSensorObject sensor = deviceContainer.getSensorById(id);
        if(fridge !=null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Fridge with id " + id + " turned on");
            fridge.getDevice().setState(DeviceState.ON);
        }
        else if(camera != null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Camera with id " + id + " turned on");
            camera.getDevice().setState(DeviceState.ON);
        }
        else if(sensor != null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Temperature sensor with id " + id + " turned on");
            sensor.getDevice().setState(DeviceState.ON);
        }
        else
            throw new InvalidArguments("Turn On ", "Device with id " + id + " does not exist");

        return status;
    }

    @Override
    public Status turnOff(String id) throws TException {
        Status status = new Status();
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        CameraObject camera = deviceContainer.getCameraById(id);
        TemperatureSensorObject sensor = deviceContainer.getSensorById(id);
        if(fridge !=null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Fridge with id " + id + " turned off");
            fridge.getDevice().setState(DeviceState.OFF);
        }
        else if(camera != null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Camera with id " + id + " turned off");
            camera.getDevice().setState(DeviceState.OFF);
        }
        else if(sensor != null) {
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Temperature sensor with id " + id + " turned off");
            sensor.getDevice().setState(DeviceState.OFF);
        }
        else
            throw new InvalidArguments("Turn Off ", "Device with id " + id + " does not exist");

        return status;
    }

    @Override
    public List<String> getEveryDevice() throws TException {
        List<String> everyDevice = new ArrayList<>();
        List<FridgeObject> fridges = deviceContainer.fridges;
        List<CameraObject> cameras = deviceContainer.cameras;
        List<TemperatureSensorObject> sensors = deviceContainer.sensors;
        for(FridgeObject fridge: fridges)
            everyDevice.add(fridge.getDevice().getId());
        for(CameraObject camera: cameras)
            everyDevice.add(camera.getDevice().getId());
        for(TemperatureSensorObject sensor: sensors)
            everyDevice.add(sensor.getDevice().getId());
        return everyDevice;
    }
}
