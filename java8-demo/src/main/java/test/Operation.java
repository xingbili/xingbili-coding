/**
 * xingbili
 */

package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xinghuolin
 * @create: 2022/5/14 10:47
 */
public class Operation {

    public static void main(String[] args) {
      // 模糊匹配 map key
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");
        map.put("f", "6");
        map.put("g", "7");
        map.put("h", "8");
        map.put("i", "9");
        map.put("j", "10");
        map.put("k", "11");
        map.put("l", "12");
        map.put("m", "13");
        map.put("n", "14");



        List<CorpSeniorDto> corpSeniorDtoList = new ArrayList<>();
        CorpSeniorDto corpSeniorDto = new CorpSeniorDto();
        corpSeniorDto.setId(1525342050164350978L);
        corpSeniorDto.setSeniorName("张三");
        corpSeniorDto.setIdNo("340521201010276018");
        corpSeniorDto.setSeniorPosition("10");
        CorpSeniorDto corpSeniorDto2 = new CorpSeniorDto();
        corpSeniorDto2.setId(1525342050189516801L);
        corpSeniorDto2.setSeniorName("李三");
        corpSeniorDto2.setSeniorPosition("10");
        corpSeniorDto2.setIdNo("340521201010276028");
        corpSeniorDtoList.add(corpSeniorDto);
        corpSeniorDtoList.add(corpSeniorDto2);
       // 同一个身份证号码不能有多个相同职位的高管

            corpSeniorDtoList.stream().collect(Collectors.groupingBy((item) -> item.getSeniorPosition() + "_" + item.getIdNo(), Collectors.collectingAndThen(
                    Collectors.toList(), list -> {
                        if (list.size() > 1) {
                            System.out.println(list.get(0).getSeniorName() + "担任" + list.get(0).getSeniorPosition() + "职务信息重复，请调整。");
                        }
                        return list;
                    }
            )));

//        // 根据证件号和职位分组查找重复数据
//         corpSeniorDtoList.stream().collect(Collectors.groupingBy((CorpSeniorDto dto) -> dto.getSeniorPosition() + "-" + dto.getIdNo(),
//                Collectors.collectingAndThen(Collectors.toList(), list -> {
//                    System.out.println(list.size());
//                    System.out.println(list);
//            if (list.size() > 1) {
//                System.out.println(list.get(0).getSeniorName() + "担任" + list.get(0).getSeniorPosition() + "职务信息重复，请调整。");
//            }
//            return list;
//        })));

//        System.out.println(corpSeniorDtoList);
        // 扣减额度

    }
}

