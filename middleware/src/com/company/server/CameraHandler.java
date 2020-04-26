package com.company.server;

import gen.rpc.thrift.*;
import org.apache.thrift.TException;

public class CameraHandler extends DeviceHandler implements Camera.Iface{
    public CameraHandler(DeviceContainer deviceContainer) {
        super(deviceContainer);
    }

    @Override
    public Status moveToPositionAndZoom(String id, AngularPosition position, int value) throws TException {
        CameraObject camera = deviceContainer.getCameraById(id);
        Status status = new Status();
        if(camera == null)
            throw new InvalidArguments("Move to position and zoom", "Camera with id " + id + " does not exist");
        if(camera.getDevice().getState() == DeviceState.DAMAGE) {
            status.setResult(ResultCode.ERROR);
            status.setMessage("Camera " + id + " is damaged");
        }
        else if(camera.getDevice().getState() == DeviceState.OFF){
            status.setResult(ResultCode.ERROR);
            status.setMessage("Camera " + id + " is turned off");
        }
        else if(camera.getDevice().getState() == DeviceState.ON){
            status.setResult(ResultCode.SUCCESS);
            status.setMessage("Camera " + id + " position and zoom successfully changed");
            camera.setZoom(value);
            camera.setPosition(position);
        }
        return status;
    }
}
