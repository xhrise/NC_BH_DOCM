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

            // ��pos�����Ƿ���tabCode,���Ϊ��ͷ���򲻴���tabCode
            if (!isPosHeadTail(pos)) {
                tabCode = scaleBean.getTabcode();
            }

            if (!isPosHeadTail(unitPos)) {
                unitTabCode = scaleBean.getUnittabcode();
            }

            /* Oct 14, 2013 wangweir ֧�ֻ����ʾ������� Begin */
            switch (scaleBean.getType()) {
                case NumAssNum:
                    scaleprocess.setNumCtlInfo(numKeys, pos, tabCode, scaleBean.getUnitkey(), unitPos, unitTabCode);
                    break;
                case HSL:
                    // ֧�ֻ�����
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
