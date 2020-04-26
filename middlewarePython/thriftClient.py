from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.protocol.TMultiplexedProtocol import TMultiplexedProtocol
import sys
import glob
import pygen.Fridge as Fridge
import pygen.Camera
import time

def main():
    # Make socket
    transport = TSocket.TSocket('localhost', 9081)

    # Buffering is critical. Raw sockets are very slow
    transport = TTransport.TBufferedTransport(transport)

    # Wrap in a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    client = Fridge.Client(TMultiplexedProtocol(protocol, "Fridge"))

    transport.open()

    print(client.getState("fridge-1"))
    transport.close()
    time.sleep(10)
    transport.open()
    print(client.getState("fridge-1"))
    transport.close()

main()