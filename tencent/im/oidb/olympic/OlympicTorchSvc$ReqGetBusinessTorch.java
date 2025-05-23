package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$ReqGetBusinessTorch extends MessageMicro<OlympicTorchSvc$ReqGetBusinessTorch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_torch_id", "msg_lbs_info", "rpt_city_pic_id_list"}, new Object[]{0L, null, 0L}, OlympicTorchSvc$ReqGetBusinessTorch.class);
    public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0);
    public MqqLbs$LBSInfo msg_lbs_info = new MqqLbs$LBSInfo();
    public final PBRepeatField<Long> rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
