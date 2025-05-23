package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$ReqBody extends MessageMicro<oidb_cmd0xcdd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"get_qr_req", "confirm_qr_req", "verify_token_req", "reject_qr_req", "query_state_req"}, new Object[]{null, null, null, null, null}, oidb_cmd0xcdd$ReqBody.class);
    public oidb_cmd0xcdd$GetQrReq get_qr_req = new oidb_cmd0xcdd$GetQrReq();
    public oidb_cmd0xcdd$ConfirmQrReq confirm_qr_req = new oidb_cmd0xcdd$ConfirmQrReq();
    public oidb_cmd0xcdd$VerifyTokenReq verify_token_req = new MessageMicro<oidb_cmd0xcdd$VerifyTokenReq>() { // from class: tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$VerifyTokenReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"token"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xcdd$VerifyTokenReq.class);
        public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_cmd0xcdd$RejectQrReq reject_qr_req = new MessageMicro<oidb_cmd0xcdd$RejectQrReq>() { // from class: tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$RejectQrReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"qr_sig", "biz_type"}, new Object[]{ByteStringMicro.EMPTY, 1}, oidb_cmd0xcdd$RejectQrReq.class);
        public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField biz_type = PBField.initEnum(1);
    };
    public oidb_cmd0xcdd$QueryStateReq query_state_req = new oidb_cmd0xcdd$QueryStateReq();
}
