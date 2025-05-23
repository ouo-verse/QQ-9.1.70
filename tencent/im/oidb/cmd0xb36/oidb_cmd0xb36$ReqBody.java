package tencent.im.oidb.cmd0xb36;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb36$ReqBody extends MessageMicro<oidb_cmd0xb36$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"group_id", "start", WidgetCacheConstellationData.NUM, "red_point_num"}, new Object[]{0L, 0, 0, 0}, oidb_cmd0xb36$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field red_point_num = PBField.initUInt32(0);
}
