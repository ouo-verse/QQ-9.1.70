package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiYoloRoomOuterClass$WujiYoloCodmRoomConfList extends MessageMicro<WujiYoloRoomOuterClass$WujiYoloCodmRoomConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiYoloRoomOuterClass$WujiYoloCodmRoomConfList.class);
    public final PBRepeatMessageField<WujiYoloRoomOuterClass$WujiYoloCodmRoomConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass$WujiYoloCodmRoomConf.class);
}
