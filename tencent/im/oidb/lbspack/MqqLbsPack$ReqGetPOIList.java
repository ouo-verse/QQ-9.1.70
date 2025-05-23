package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.olympic.MqqLbs$LBSInfo;

/* loaded from: classes29.dex */
public final class MqqLbsPack$ReqGetPOIList extends MessageMicro<MqqLbsPack$ReqGetPOIList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82, 90, 96, 106}, new String[]{"int32_lat", "int32_lon", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig"}, new Object[]{900000000, 900000000, null, null, 0, ByteStringMicro.EMPTY}, MqqLbsPack$ReqGetPOIList.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public MqqLbsPack$LBSSig msg_lbs_sig = new MqqLbsPack$LBSSig();
    public MqqLbs$LBSInfo msg_lbs_info = new MqqLbs$LBSInfo();
    public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
    public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
