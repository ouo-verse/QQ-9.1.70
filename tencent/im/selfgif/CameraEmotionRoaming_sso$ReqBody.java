package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$ReqBody extends MessageMicro<CameraEmotionRoaming_sso$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66}, new String[]{"uint64_src_uin", "uint32_src_term", "bytes_version", "uint32_cmd_type", "upLoad_req", "upLoad_state_req", "get_list_req", "del_req"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, null, null, null, null}, CameraEmotionRoaming_sso$ReqBody.class);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    public CameraEmotionRoaming_sso$UpLoadReq upLoad_req = new CameraEmotionRoaming_sso$UpLoadReq();
    public CameraEmotionRoaming_sso$UpLoadStateReq upLoad_state_req = new CameraEmotionRoaming_sso$UpLoadStateReq();
    public CameraEmotionRoaming_sso$GetListReq get_list_req = new CameraEmotionRoaming_sso$GetListReq();
    public CameraEmotionRoaming_sso$DelReq del_req = new CameraEmotionRoaming_sso$DelReq();
}
