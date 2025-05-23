package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.olympic.MqqLbs$LBSInfo;

/* loaded from: classes29.dex */
public final class MqqLbsPack$ReqGetLBSRPList extends MessageMicro<MqqLbsPack$ReqGetLBSRPList> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie;
    public final PBBytesField bytes_encrypt_sig;
    public final PBBytesField bytes_page_cookie;
    public final PBBytesField bytes_pid;
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public MqqLbs$LBSInfo msg_lbs_info;
    public MqqLbsPack$LBSSig msg_lbs_sig;
    public final PBUInt32Field uint32_lbs_accuracy;
    public final PBUInt32Field uint32_req_occasion;
    public final PBUInt64Field uint64_adcode;
    public final PBUInt64Field uint64_poi_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 64, 82, 90, 96, 106}, new String[]{"int32_lat", "int32_lon", "bytes_cookie", "bytes_pid", "uint64_poi_id", "bytes_page_cookie", "uint64_adcode", "uint32_req_occasion", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig"}, new Object[]{900000000, 900000000, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0L, 0, null, null, 0, byteStringMicro}, MqqLbsPack$ReqGetLBSRPList.class);
    }

    public MqqLbsPack$ReqGetLBSRPList() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
        this.bytes_pid = PBField.initBytes(byteStringMicro);
        this.uint64_poi_id = PBField.initUInt64(0L);
        this.bytes_page_cookie = PBField.initBytes(byteStringMicro);
        this.uint64_adcode = PBField.initUInt64(0L);
        this.uint32_req_occasion = PBField.initUInt32(0);
        this.msg_lbs_sig = new MqqLbsPack$LBSSig();
        this.msg_lbs_info = new MqqLbs$LBSInfo();
        this.uint32_lbs_accuracy = PBField.initUInt32(0);
        this.bytes_encrypt_sig = PBField.initBytes(byteStringMicro);
    }
}
