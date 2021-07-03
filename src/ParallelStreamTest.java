/**
 * @author sunmengyuan
 * @date 2021-07-03
 */

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author sunmengyuan
 * @date 2021-07-02
 */
public class ParallelStreamTest {
    private static final int COUNT = 1000;

    public static void main(String[] args) {
        List<RiderDto> orilist = new ArrayList<RiderDto>();
        for (int i = 0; i < COUNT; i++) {
            orilist.add(init());
        }
        // 有问题
        // 或者ArrayList改用CopyOnWriteArrayList
//        final List<RiderDto> copeList = new ArrayList<>();
//        orilist.parallelStream().forEach(rider -> {
//            RiderDto t = new RiderDto();
//            t.setId(rider.getId());
//            t.setCityId(rider.getCityId());
//            copeList.add(t);
//        });

        // 不会有问题
        List<RiderDto> copeList = orilist.parallelStream().map(o -> {
            RiderDto t = new RiderDto();
            t.setId(o.getId());
            t.setCityId(o.getCityId());
            return t;
        }).collect(Collectors.toList());

        System.out.println("orilist size:" + orilist.size());
        System.out.println("copeList size:" + copeList.size());
        System.out.println("compare copeList and list,result:" + (copeList.size() == orilist.size()));
    }

    private static RiderDto init() {
        RiderDto t = new RiderDto();
        Random random = new Random();
        t.setId(random.nextInt(2 ^ 20));
        t.setCityId(random.nextInt(1000));
        return t;
    }

    @Data
    static class RiderDto implements Serializable {
        private static final long serialVersionUID = 1;
        //城市Id
        private Integer cityId;
        //骑手Id
        private Integer id;
    }
}
