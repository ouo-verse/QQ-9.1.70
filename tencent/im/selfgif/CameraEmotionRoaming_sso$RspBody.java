package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$RspBody extends MessageMicro<CameraEmotionRoaming_sso$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_rsp_other;
    public CameraEmotionRoaming_sso$DelRsp del_rsp;
    public CameraEmotionRoaming_sso$GetListRsp get_list_rsp;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_cmd_type;
    public CameraEmotionRoaming_sso$UpLoadRsp upLoad_rsp;
    public CameraEmotionRoaming_sso$UpLoadStateRsp upLoad_state_rsp;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66}, new String[]{"int32_result", "bytes_fail_msg", "uint32_cmd_type", "upLoad_rsp", "upLoad_state_rsp", "get_list_rsp", "del_rsp", "bytes_rsp_other"}, new Object[]{0, byteStringMicro, 0, null, null, null, null, byteStringMicro}, CameraEmotionRoaming_sso$RspBody.class);
    }

    public CameraEmotionRoaming_sso$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.uint32_cmd_type = PBField.initUInt32(0);
        this.upLoad_rsp = new CameraEmotionRoaming_sso$UpLoadRsp();
        this.upLoad_state_rsp = new CameraEmotionRoaming_sso$UpLoadStateRsp();
        this.get_list_rsp = new CameraEmotionRoaming_sso$GetListRsp();
        this.del_rsp = new CameraEmotionRoaming_sso$DelRsp();
        this.bytes_rsp_other = PBField.initBytes(byteStringMicro);
    }
}
