package com.company.server;

import gen.rpc.thrift.*;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class SmartHomeServer {
    public static final int devicesAmount = 10;
    public static void main(String[] args) {
        DeviceContainer deviceContainer = new DeviceContainer();
        deviceContainer.generateDevices();
        try {
            Fridge.Processor<FridgeHandler> fridgeProcessor = new Fridge.Processor<>(new FridgeHandler(deviceContainer));
            Camera.Processor<CameraHandler> cameraProcessor = new Camera.Processor<>(new CameraHandler(deviceContainer));
            TemperatureSensor.Processor<TemperatureSensorHandler> temperatureSensorProcessor =
                    new TemperatureSensor.Processor<>(new TemperatureSensorHandler(deviceContainer));
            Device.Processor<DeviceHandler> deviceProcessor = new Device.Processor<>(new DeviceHandler(deviceContainer));
            TServerTransport serverTransport = new TServerSocket(9081);
            TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

            TMultiplexedProcessor multiplex = new TMultiplexedProcessor();
            multiplex.registerProcessor("Fridge", fridgeProcessor);
            multiplex.registerProcessor("Camera", cameraProcessor);
            multiplex.registerProcessor("TemperatureSensor", temperatureSensorProcessor);
            multiplex.registerProcessor("Device", deviceProcessor);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).
                    protocolFactory(protocolFactory).processor(multiplex));
            server.serve();
        } catch (TTransportException e) {
            throw new RuntimeException("Connection failure - Exiting!");
        }

    }
}
