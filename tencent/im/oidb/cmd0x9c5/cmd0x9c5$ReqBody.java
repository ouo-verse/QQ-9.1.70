package tencent.im.oidb.cmd0x9c5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c5$ReqBody extends MessageMicro<cmd0x9c5$ReqBody> {
    public static final int RPT_UINT32_TAG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint32_tag_type"}, new Object[]{0}, cmd0x9c5$ReqBody.class);
    public final PBRepeatField<Integer> rpt_uint32_tag_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
