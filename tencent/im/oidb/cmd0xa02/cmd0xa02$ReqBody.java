package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xa02$ReqBody extends MessageMicro<cmd0xa02$ReqBody> {
    public static final int RPT_TINYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_tinyid"}, new Object[]{null}, cmd0xa02$ReqBody.class);
    public final PBRepeatMessageField<cmd0xa02$TinyID> rpt_tinyid = PBField.initRepeatMessage(cmd0xa02$TinyID.class);
}
