package java.basis.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelDemo {

    public static void main(String[] args) throws IOException {
//        FileChannel // 文件IO
//        SocketChannel // 网络IO
//        ServerSocketChannel
//        DatagramChannel // UDP

//        FileInputStream fileInputStream = new FileInputStream("1.jpg");
//        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");
//
//        FileChannel inChannel = fileInputStream.getChannel();
//        FileChannel outChannel = fileOutputStream.getChannel();
//
//        // 分配缓冲区
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//
//        while (inChannel.read(buffer) != -1) {
//            buffer.flip();
//            outChannel.write(buffer);
//            buffer.clear();
//        }
//
//        outChannel.close();
//        inChannel.close();
//        fileOutputStream.close();
//        fileInputStream.close();
//
//        ----------------------------------------------------------------------------
        FileChannel inChannel = FileChannel.open(Paths.get("timg.jpeg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("timg2.jpeg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        // 内存映射文件(只有 ByteBuffer 支持内存映射)
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());

        byte[] dst = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(dst);
        outMappedByteBuffer.put(dst);

        inChannel.close();
        outChannel.close();
        //        ----------------------------------------------------------------------------
        FileChannel inChannel1 = FileChannel.open(Paths.get("timg.jpeg"), StandardOpenOption.READ);
        FileChannel outChannel1 = FileChannel.open(Paths.get("timg2.jpeg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        inChannel1.transferTo(0, inChannel1.size(), outChannel1);

        inChannel.close();
        outChannel.close();
    }
}
