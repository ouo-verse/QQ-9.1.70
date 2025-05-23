package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x97b$RspBody extends MessageMicro<oidb_cmd0x97b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_uin", "msg_follow_count_info", "msg_limit_info", "msg_simpleinfo"}, new Object[]{0L, null, null, null}, oidb_cmd0x97b$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0x97b$FollowCountInfo msg_follow_count_info = new MessageMicro<oidb_cmd0x97b$FollowCountInfo>() { // from class: tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$FollowCountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 162}, new String[]{"uint32_my_follow_count", "uint32_my_fans_count", "uint32_is_buluo_vip", "bytes_buluo_name", "uint32_buluo_id", "uint32_buluo_fans_count", "rpt_fans_detail_info"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY, 0, 0, null}, oidb_cmd0x97b$FollowCountInfo.class);
        public final PBUInt32Field uint32_my_follow_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_my_fans_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_buluo_vip = PBField.initUInt32(0);
        public final PBBytesField bytes_buluo_name = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_buluo_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_buluo_fans_count = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_cmd0x97b$CountDetailInfo> rpt_fans_detail_info = PBField.initRepeatMessage(oidb_cmd0x97b$CountDetailInfo.class);
    };
    public oidb_cmd0x97b$LimitInfo msg_limit_info = new MessageMicro<oidb_cmd0x97b$LimitInfo>() { // from class: tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$LimitInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_forbidden_flag"}, new Object[]{0}, oidb_cmd0x97b$LimitInfo.class);
        public final PBUInt32Field uint32_forbidden_flag = PBField.initUInt32(0);
    };
    public oidb_cmd0x97b$SimpleInfo msg_simpleinfo = new MessageMicro<oidb_cmd0x97b$SimpleInfo>() { // from class: tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$SimpleInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_header_url;
        public final PBBytesField bytes_nick;
        public final PBInt64Field int64_like_total;
        public final PBInt64Field int64_publish_feeds_total;
        public oidb_cmd0x97b$ColumnInfo msg_column_info;
        public oidb_cmd0x97b$SignIn msg_sign_in;
        public final PBRepeatMessageField<oidb_cmd0x97b$MedalInfo> rpt_msg_medal_info;
        public final PBUInt32Field uint32_is_vip;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 48, 56, 66, 90, 98}, new String[]{"bytes_nick", "bytes_header_url", "uint32_is_vip", "bytes_desc", "int64_like_total", "int64_publish_feeds_total", "rpt_msg_medal_info", "msg_sign_in", "msg_column_info"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, 0L, null, null, null}, oidb_cmd0x97b$SimpleInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$SignIn] */
        /* JADX WARN: Type inference failed for: r0v7, types: [tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$ColumnInfo] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick = PBField.initBytes(byteStringMicro);
            this.bytes_header_url = PBField.initBytes(byteStringMicro);
            this.uint32_is_vip = PBField.initUInt32(0);
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.int64_like_total = PBField.initInt64(0L);
            this.int64_publish_feeds_total = PBField.initInt64(0L);
            this.rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0x97b$MedalInfo.class);
            this.msg_sign_in = new MessageMicro<oidb_cmd0x97b$SignIn>() { // from class: tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$SignIn
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int64_status", "uint32_current_continuous_sign_days", "uint32_max_continuous_sign_days"}, new Object[]{0L, 0, 0}, oidb_cmd0x97b$SignIn.class);
                public final PBInt64Field int64_status = PBField.initInt64(0);
                public final PBUInt32Field uint32_current_continuous_sign_days = PBField.initUInt32(0);
                public final PBUInt32Field uint32_max_continuous_sign_days = PBField.initUInt32(0);
            };
            this.msg_column_info = new MessageMicro<oidb_cmd0x97b$ColumnInfo>() { // from class: tencent.im.oidb.cmd0x97b.oidb_cmd0x97b$ColumnInfo
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_column_jump_url;
                public final PBBytesField bytes_subscribe_jump_url;
                public final PBBytesField bytes_video_jump_url;
                public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
                public final PBUInt32Field uint32_column_count = PBField.initUInt32(0);
                public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 98, 106}, new String[]{"uint32_video_count", "uint32_column_count", "uint32_subscribe_count", "bytes_video_jump_url", "bytes_column_jump_url", "bytes_subscribe_jump_url"}, new Object[]{0, 0, 0, byteStringMicro2, byteStringMicro2, byteStringMicro2}, oidb_cmd0x97b$ColumnInfo.class);
                }

                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.bytes_video_jump_url = PBField.initBytes(byteStringMicro2);
                    this.bytes_column_jump_url = PBField.initBytes(byteStringMicro2);
                    this.bytes_subscribe_jump_url = PBField.initBytes(byteStringMicro2);
                }
            };
        }
    };
}
