package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiYoloRoomOuterClass$WujiYoloSmobaRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloSmobaRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloSmobaRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf.class);
}
