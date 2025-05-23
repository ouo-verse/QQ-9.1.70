package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x977$FollowStatusInfo extends MessageMicro<oidb_cmd0x977$FollowStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 82, 88, 96, 106, 112}, new String[]{"uint64_uin", "enum_status", "enum_account_type", "enum_fans_status", "msg_topic_info", "enum_forbid_idol_status", "enum_forbid_fans_status", "user_info", "uint32_is_being_followed"}, new Object[]{0L, 0, 1, 0, null, -1, -1, null, 0}, oidb_cmd0x977$FollowStatusInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_status = PBField.initEnum(0);
    public final PBEnumField enum_account_type = PBField.initEnum(1);
    public final PBEnumField enum_fans_status = PBField.initEnum(0);
    public oidb_cmd0x977$FollowTopicInfo msg_topic_info = new MessageMicro<oidb_cmd0x977$FollowTopicInfo>() { // from class: tencent.im.oidb.cmd0x977.oidb_cmd0x977$FollowTopicInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_name;
        public final PBBytesField bytes_picurl;
        public final PBBytesField bytes_url;
        public final PBUInt32Field uint32_source;
        public final PBUInt32Field uint32_unreadcount;
        public final PBUInt32Field uint32_usercount;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 80}, new String[]{"bytes_name", "bytes_picurl", "uint32_usercount", "uint32_unreadcount", "bytes_url", "uint32_source"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0}, oidb_cmd0x977$FollowTopicInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_name = PBField.initBytes(byteStringMicro);
            this.bytes_picurl = PBField.initBytes(byteStringMicro);
            this.uint32_usercount = PBField.initUInt32(0);
            this.uint32_unreadcount = PBField.initUInt32(0);
            this.bytes_url = PBField.initBytes(byteStringMicro);
            this.uint32_source = PBField.initUInt32(0);
        }
    };
    public final PBEnumField enum_forbid_idol_status = PBField.initEnum(-1);
    public final PBEnumField enum_forbid_fans_status = PBField.initEnum(-1);
    public oidb_cmd0x977$KdUserInfo user_info = new MessageMicro<oidb_cmd0x977$KdUserInfo>() { // from class: tencent.im.oidb.cmd0x977.oidb_cmd0x977$KdUserInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_nick;
        public final PBBytesField bytes_qq_head_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_nick", "bytes_qq_head_url"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_cmd0x977$KdUserInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_nick = PBField.initBytes(byteStringMicro);
            this.bytes_qq_head_url = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBUInt32Field uint32_is_being_followed = PBField.initUInt32(0);
}
