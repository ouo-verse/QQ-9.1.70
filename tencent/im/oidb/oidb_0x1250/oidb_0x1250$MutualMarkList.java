package tencent.im.oidb.oidb_0x1250;

import com.tencent.mobileqq.partner.signin.pb.SigninPB$SignInInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.mutualmark.mutualmark$State;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1250$MutualMarkList extends MessageMicro<oidb_0x1250$MutualMarkList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"lightup_num", "total_num", "rpt_all_mutual_mark", "rpt_prefetch_mutual_mark", "rpt_degrade_mutual_mark", "rpt_lightoff_mutual_mark", "bytes_recover_info", "guides", "partner_infos", "sign_in_infos"}, new Object[]{0, 0, null, null, null, null, ByteStringMicro.EMPTY, null, null, null}, oidb_0x1250$MutualMarkList.class);
    public final PBUInt32Field lightup_num = PBField.initUInt32(0);
    public final PBUInt32Field total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<mutualmark$State> rpt_all_mutual_mark = PBField.initRepeatMessage(mutualmark$State.class);
    public final PBRepeatMessageField<mutualmark$State> rpt_prefetch_mutual_mark = PBField.initRepeatMessage(mutualmark$State.class);
    public final PBRepeatMessageField<mutualmark$State> rpt_degrade_mutual_mark = PBField.initRepeatMessage(mutualmark$State.class);
    public final PBRepeatMessageField<mutualmark$State> rpt_lightoff_mutual_mark = PBField.initRepeatMessage(mutualmark$State.class);
    public final PBBytesField bytes_recover_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x1250$Guide> guides = PBField.initRepeatMessage(oidb_0x1250$Guide.class);
    public final PBRepeatMessageField<oidb_0x1250$PartnerInfo> partner_infos = PBField.initRepeatMessage(oidb_0x1250$PartnerInfo.class);
    public final PBRepeatMessageField<SigninPB$SignInInfo> sign_in_infos = PBField.initRepeatMessage(SigninPB$SignInInfo.class);
}
