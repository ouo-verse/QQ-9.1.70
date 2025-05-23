package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xa02$RspBody extends MessageMicro<cmd0xa02$RspBody> {
    public static final int RPT_TINYID2USERACC_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_tinyid2useracc_info"}, new Object[]{null}, cmd0xa02$RspBody.class);
    public final PBRepeatMessageField<cmd0xa02$TinyID2UserAccInfo> rpt_tinyid2useracc_info = PBField.initRepeatMessage(cmd0xa02$TinyID2UserAccInfo.class);
}
