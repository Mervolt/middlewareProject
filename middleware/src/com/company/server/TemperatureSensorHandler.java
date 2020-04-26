package com.company.server;

import gen.rpc.thrift.*;
import org.apache.thrift.TException;

public class TemperatureSensorHandler extends DeviceHandler implements TemperatureSensor.Iface {
    public TemperatureSensorHandler(DeviceContainer deviceContainer) {
        super(deviceContainer);
    }

    @Override
    public Status changeAlarmTemperatureValue(String id, int alarmValue) throws TException {
        TemperatureSensorObject sensor = deviceContainer.getSensorById(id);
        Status status = new Status();
        if(sensor == null)
            throw new InvalidArguments("Change alarm temp. value", "Sensor with id " + id + " does not exist");
        if(sensor.getDevice().getState() == DeviceState.DAMAGE) {
            status.setResult(ResultCode.ERROR);
            status.setMessage("Temperature sensor " + id + " is damaged");
        }
        else if(sensor.getDevice().getState() == DeviceState.OFF){
            status.setResult(ResultCode.ERROR);
            status.setMessage("Temperature sensor " + id + " is turned off");
        }
        else if(sensor.getDevice().getState() == DeviceState.ON){
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Temperature sensor " + id + " alarm value changed to " + alarmValue);
            sensor.setAlarmValue(alarmValue);
        }
        return status;
    }

    @Override
    public int getTemperature(String id) throws TException {
        TemperatureSensorObject sensor = deviceContainer.getSensorById(id);
        if(sensor == null)
            throw new InvalidArguments("Get temperature ", "Sensor with id " + id + " does not exist");
        return sensor.getTemperature();
    }
}
