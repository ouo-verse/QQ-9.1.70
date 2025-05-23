package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb40$ReqBody extends MessageMicro<oidb_0xb40$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_check_favorite_req", "msg_get_favorite_list_req"}, new Object[]{null, null}, oidb_0xb40$ReqBody.class);
    public oidb_0xb40$CheckFavoriteReqBody msg_check_favorite_req = new MessageMicro<oidb_0xb40$CheckFavoriteReqBody>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$CheckFavoriteReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bytes_rowkey"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xb40$CheckFavoriteReqBody.class);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    };
    public oidb_0xb40$GetFavoriteListReqBody msg_get_favorite_list_req = new MessageMicro<oidb_0xb40$GetFavoriteListReqBody>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$GetFavoriteListReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_sync_cookie", "uint32_page_size"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0xb40$GetFavoriteListReqBody.class);
        public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    };
}
