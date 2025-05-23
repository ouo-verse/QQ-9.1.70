package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xee9$UserInfoItem extends MessageMicro<oidb_cmd0xee9$UserInfoItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "msg_live_status"}, new Object[]{0L, null}, oidb_cmd0xee9$UserInfoItem.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0xee9$LiveStatus msg_live_status = new MessageMicro<oidb_cmd0xee9$LiveStatus>() { // from class: tencent.im.oidb.cmd0xee9.oidb_cmd0xee9$LiveStatus
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58}, new String[]{"uint32_liveing", "uint64_live_time", "uint32_source", "str_account", "str_roomid", "rowkey", "str_url"}, new Object[]{0, 0L, 0, "", "", "", ""}, oidb_cmd0xee9$LiveStatus.class);
        public final PBUInt32Field uint32_liveing = PBField.initUInt32(0);
        public final PBUInt64Field uint64_live_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_source = PBField.initUInt32(0);
        public final PBStringField str_account = PBField.initString("");
        public final PBStringField str_roomid = PBField.initString("");
        public final PBStringField rowkey = PBField.initString("");
        public final PBStringField str_url = PBField.initString("");
    };
}
