package tencent.im.oidb.cmd0x802;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x802$ReqBody extends MessageMicro<oidb_0x802$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_join_room_auth_buf_req"}, new Object[]{null}, oidb_0x802$ReqBody.class);
    public oidb_0x802$JoinRoomAuthBufReq msg_join_room_auth_buf_req = new MessageMicro<oidb_0x802$JoinRoomAuthBufReq>() { // from class: tencent.im.oidb.cmd0x802.oidb_0x802$JoinRoomAuthBufReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"int32_roomID", "bytes_identifier", "int64_peerUin"}, new Object[]{0, ByteStringMicro.EMPTY, 0L}, oidb_0x802$JoinRoomAuthBufReq.class);
        public final PBInt32Field int32_roomID = PBField.initInt32(0);
        public final PBBytesField bytes_identifier = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt64Field int64_peerUin = PBField.initInt64(0);
    };
}
