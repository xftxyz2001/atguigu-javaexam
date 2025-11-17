import java.util.LinkedList;
import java.util.Scanner;

public class MemoryPool {
    private static final int TOTAL = 100;

    // 分区结构
    static class Block {
        int start;
        int size;

        Block(int start, int size) {
            this.start = start;
            this.size = size;
        }
    }

    // 空闲链表：按地址升序
    private final LinkedList<Block> freeList = new LinkedList<>();

    // 已分配链表：按地址升序
    private final LinkedList<Block> allocList = new LinkedList<>();

    public MemoryPool() {
        // 初始化空闲链表：一个完整 100 字节区域
        freeList.add(new Block(0, TOTAL));
    }

    /**
     * 分配 size 字节
     * 返回首地址，失败返回 -1
     */
    public int allocate(int size) {
        if (size <= 0)
            return -1;

        for (int i = 0; i < freeList.size(); i++) {
            Block free = freeList.get(i);
            if (free.size >= size) {

                int addr = free.start;

                // 分割空闲块
                free.start += size;
                free.size -= size;

                // 如果空闲块用尽，删除
                if (free.size == 0) {
                    freeList.remove(i);
                }

                // 插入到已分配链表
                insertAllocated(new Block(addr, size));

                return addr;
            }
        }

        // 无可用空间
        return -1;
    }

    /**
     * 释放内存块，成功返回 true，失败（地址无效）返回 false
     */
    public boolean free(int addr) {
        Block target = null;

        for (Block b : allocList) {
            if (b.start == addr) {
                target = b;
                break;
            }
        }

        if (target == null)
            return false;

        allocList.remove(target);

        // 插回空闲链表并尝试合并
        insertFreeAndMerge(target);

        return true;
    }

    // 将分配块按地址插入到 allocList（有序）
    private void insertAllocated(Block block) {
        int idx = 0;
        while (idx < allocList.size() && allocList.get(idx).start < block.start) {
            idx++;
        }
        allocList.add(idx, block);
    }

    // 插入到 freeList 并合并前后空闲块
    private void insertFreeAndMerge(Block block) {
        int idx = 0;

        while (idx < freeList.size() && freeList.get(idx).start < block.start) {
            idx++;
        }

        freeList.add(idx, block);

        // 合并前一个
        if (idx > 0) {
            Block prev = freeList.get(idx - 1);
            if (prev.start + prev.size == block.start) {
                prev.size += block.size;
                freeList.remove(idx);
                block = prev;
                idx--;
            }
        }

        // 合并后一个
        if (idx < freeList.size() - 1) {
            Block next = freeList.get(idx + 1);
            if (block.start + block.size == next.start) {
                block.size += next.size;
                freeList.remove(idx + 1);
            }
        }
    }
}

class MemoryPoolTest {
    public static void main(String[] args) {
        MemoryPool pool = new MemoryPool();
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine().trim();

            if (cmd.startsWith("REQUEST=")) {
                int size = Integer.parseInt(cmd.substring(8));
                int addr = pool.allocate(size);
                if (addr == -1)
                    System.out.println("error");
                else
                    System.out.println(addr);

            } else if (cmd.startsWith("RELEASE=")) {
                int addr = Integer.parseInt(cmd.substring(8));
                if (!pool.free(addr))
                    System.out.println("error");
            }
        }
    }

}