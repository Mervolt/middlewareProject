package com.company.server;

import gen.rpc.thrift.*;
import org.apache.thrift.TException;

public class FridgeHandler extends DeviceHandler implements Fridge.Iface{
    public FridgeHandler(DeviceContainer deviceContainer) {
        super(deviceContainer);
    }

    @Override
    public Status startFreezing(String id) throws TException {
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        Status status = new Status();
        if(fridge == null)
            throw new InvalidArguments("Start Freezing", "Fridge with id " + id + " does not exist");
        if(fridge.getDevice().getState() == DeviceState.DAMAGE) {
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is damaged");
        }
        else if(fridge.getDevice().getState() == DeviceState.OFF){
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is turned off");
        }
        else if(fridge.getDevice().getState() == DeviceState.ON){
            status.setResult(ResultCode.SUCCESS);
            if(fridge.getFridgeState().isIsFreezing()) {
                status.setMessage("Fridge was already freezing " + id);
            }
            else {
                fridge.getFridgeState().setIsFreezing(true);
                status.setMessage("Freezing turned on in Fridge " + id);
            }
        }
        return status;
    }

    @Override
    public Status stopFreezing(String id) throws TException {
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        Status status = new Status();
        if(fridge == null)
            throw new InvalidArguments("Stop Freezing", "Fridge with id " + id + " does not exist");
        if(fridge.getDevice().getState() == DeviceState.DAMAGE) {
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is damaged");
        }
        else if(fridge.getDevice().getState() == DeviceState.OFF){
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is turned off");
        }
        else if(fridge.getDevice().getState() == DeviceState.ON){
            status.setResult(ResultCode.SUCCESS);
            if(fridge.getFridgeState().isIsFreezing()) {
                fridge.getFridgeState().setIsFreezing(false);
                status.setMessage("Freezing turned on in Fridge " + id);
            }
            else {
                status.setMessage("Freezing was already turned off in Fridge " + id);
            }
        }
        return status;
    }

    @Override
    public Status changeTemperatureTo(String id, int value) throws TException {
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        Status status = new Status();
        if(fridge == null)
            throw new InvalidArguments("Change temperature", "Fridge with id " + id + " does not exist");
        if(fridge.getDevice().getState() == DeviceState.DAMAGE) {
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is damaged");
        }
        else if(fridge.getDevice().getState() == DeviceState.OFF){
            status.setResult(ResultCode.ERROR);
            status.setMessage("Fridge " + id + " is turned off");
        }
        else if(fridge.getDevice().getState() == DeviceState.ON){
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Temperature successfully changed in device " + id);
            fridge.getFridgeState().setTemperature(value);
        }
        return status;
    }

    @Override
    public FridgeState getTemperatureAndIsFreezing(String id) throws TException {
        FridgeObject fridge = deviceContainer.getFridgeById(id);
        if(fridge == null)
            throw new InvalidArguments("Get temperature and freezing state", "Fridge with id " + id + " does not exist");
        return fridge.getFridgeState();
    }
}
