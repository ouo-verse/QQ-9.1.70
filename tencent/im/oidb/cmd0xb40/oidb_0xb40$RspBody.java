package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb40$RspBody extends MessageMicro<oidb_0xb40$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_check_favorite_rsp", "msg_get_favorite_list_rsp"}, new Object[]{null, null}, oidb_0xb40$RspBody.class);
    public oidb_0xb40$CheckFavoriteRspBody msg_check_favorite_rsp = new MessageMicro<oidb_0xb40$CheckFavoriteRspBody>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$CheckFavoriteRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_rsp_items"}, new Object[]{null}, oidb_0xb40$CheckFavoriteRspBody.class);
        public final PBRepeatMessageField<oidb_0xb40$CheckFavoriteRspItem> rpt_msg_rsp_items = PBField.initRepeatMessage(oidb_0xb40$CheckFavoriteRspItem.class);
    };
    public oidb_0xb40$GetFavoriteListRspBody msg_get_favorite_list_rsp = new MessageMicro<oidb_0xb40$GetFavoriteListRspBody>() { // from class: tencent.im.oidb.cmd0xb40.oidb_0xb40$GetFavoriteListRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"bytes_next_cookie", "uint32_is_end", "uint32_total", "rpt_msg_favorite_items"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, null}, oidb_0xb40$GetFavoriteListRspBody.class);
        public final PBBytesField bytes_next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBUInt32Field uint32_total = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0xb40$FavoriteItem> rpt_msg_favorite_items = PBField.initRepeatMessage(oidb_0xb40$FavoriteItem.class);
    };
}
