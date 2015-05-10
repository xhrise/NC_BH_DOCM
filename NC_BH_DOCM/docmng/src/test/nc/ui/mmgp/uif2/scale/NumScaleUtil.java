package nc.ui.mmgp.uif2.scale;

import java.util.List;

import nc.vo.mmgp.util.MMArrayUtil;
import nc.vo.mmgp.util.MMListUtil;
import nc.vo.pubapp.scale.BillScaleProcessor;
import nc.vo.pubapp.scale.PosEnum;

public class NumScaleUtil {
    
    public static void setScale(BillScaleProcessor scaleprocess,
                                MMGPNumScaleBean[] scaleBeans) {

        if (MMArrayUtil.isEmpty(scaleBeans)) {
            return;
        }
        for (MMGPNumScaleBean scaleBean : scaleBeans) {
            List<String> numKeyList = scaleBean.getNumkeys();
            if (MMListUtil.isEmpty(numKeyList)) {
                continue;
            }

            String[] numKeys = numKeyList.toArray(new String[0]);
            PosEnum pos = getPosEnum(scaleBean.getPos());
            PosEnum unitPos = getPosEnum(scaleBean.getUnitpos());

            String tabCode = null;
            String unitTabCode = null;

            // 由pos决定是否传入tabCode,如果为表头，则不传入tabCode
            if (!isPosHeadTail(pos)) {
                tabCode = scaleBean.getTabcode();
            }

            if (!isPosHeadTail(unitPos)) {
                unitTabCode = scaleBean.getUnittabcode();
            }

            /* Oct 14, 2013 wangweir 支持换算率精度配置 Begin */
            switch (scaleBean.getType()) {
                case NumAssNum:
                    scaleprocess.setNumCtlInfo(numKeys, pos, tabCode, scaleBean.getUnitkey(), unitPos, unitTabCode);
                    break;
                case HSL:
                    // 支持换算率
                    scaleprocess.setHslCtlInfo(numKeys, pos, tabCode);
                    break;
                case WEIGHT:
                    scaleprocess.setWeightCtlInfo(numKeys, pos, tabCode);
                    break;
            }
            /* Oct 14, 2013 wangweir End */
        }

        scaleprocess.process();

    }

    private static PosEnum getPosEnum(int posNum) {
        if (PosEnum.head.getCode() == posNum) {
            return PosEnum.head;
        } else if (PosEnum.body.getCode() == posNum) {
            return PosEnum.body;
        } else if (PosEnum.tail.getCode() == posNum) {
            return PosEnum.tail;
        }
        return null;
    }

    private static boolean isPosHeadTail(PosEnum pos) {
        if (PosEnum.head.getCode() == pos.getCode()) {
            return true;
        }
        if (PosEnum.tail.getCode() == pos.getCode()) {
            return true;
        }

        return false;
    }

}
