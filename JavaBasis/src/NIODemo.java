import java.nio.ByteBuffer;

/**
 * Buffer 核心属性:
 * // Invariants: mark <= position <= limit <= capacity
 * <p>
 * private int mark = -1;
 * private int position = 0; 当前的读写位置
 * private int limit; 可操作的数据量的大小, limit后面的数据不能读写
 * private int capacity; 最大存储容量,一旦声明不能修改
 */

public class NIODemo {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);// 底层是数组
        ByteBuffer buff = ByteBuffer.allocateDirect(1024);// 直接写到物理内存中
        System.out.println(buff.isDirect());
//        IntBuffer intBuffer
//        LongBuffer longBuffer
//        CharBuffer charBuffer

        String str = "abcde";
        buffer.put(str.getBytes());
        System.out.println(buffer.position()); // 5
        System.out.println(buffer.limit()); // 1024
        System.out.println(buffer.capacity());// 1024

        buffer.flip();
        System.out.println(buffer.position());// 0
        System.out.println(buffer.limit());// 5
        System.out.println(buffer.capacity());// 1024


        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(buffer.position());// 5
        System.out.println(buffer.limit());// 5
        System.out.println(buffer.capacity());// 1024

        buffer.rewind();
        System.out.println(buffer.position());// 0
        System.out.println(buffer.limit());// 5
        System.out.println(buffer.capacity());// 1024

        buffer.clear();// 数据还在
        System.out.println(buffer.remaining()); // 1024 limit - position
        System.out.println(buffer.position());// 0
        System.out.println(buffer.limit());// 1024
        System.out.println(buffer.capacity());// 1024


        // mark reset
        buffer.mark();
//        ...
        buffer.reset();// 回到mark的位置
    }
}
