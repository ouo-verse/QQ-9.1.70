package tencent.im.oidb.cmd0x802;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x802$RspBody extends MessageMicro<oidb_0x802$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_join_room_auth_buf_rsp"}, new Object[]{null}, oidb_0x802$RspBody.class);
    public oidb_0x802$JoinRoomAuthBufRsp msg_join_room_auth_buf_rsp = new MessageMicro<oidb_0x802$JoinRoomAuthBufRsp>() { // from class: tencent.im.oidb.cmd0x802.oidb_0x802$JoinRoomAuthBufRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_encrypt_buf"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x802$JoinRoomAuthBufRsp.class);
        public final PBBytesField bytes_encrypt_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
