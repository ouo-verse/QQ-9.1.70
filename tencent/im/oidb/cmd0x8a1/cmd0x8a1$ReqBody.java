package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8a1$ReqBody extends MessageMicro<cmd0x8a1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_create_option", "msg_create_group_info", "msg_select_group_code_info"}, new Object[]{0, null, null}, cmd0x8a1$ReqBody.class);
    public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
    public cmd0x8a1$CreateGroupInfo msg_create_group_info = new MessageMicro<cmd0x8a1$CreateGroupInfo>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$CreateGroupInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public cmd0x8a1$ChannelInfo msg_channel_info;
        public cmd0x8a1$ClientInfo msg_client_info;
        public cmd0x8a1$GroupGeoInfo msg_group_geo_info;
        public final PBBytesField string_answer;
        public final PBBytesField string_group_finger_memo;
        public final PBBytesField string_group_memo;
        public final PBBytesField string_group_name;
        public final PBBytesField string_group_rich_finger_memo;
        public final PBBytesField string_question;
        public final PBBytesField string_sign;
        public cmd0x8a1$TypeValues type_value_info;
        public final PBUInt32Field uint32_check_limit_flag;
        public final PBUInt32Field uint32_conf_uin;
        public final PBUInt32Field uint32_group_face_flag;
        public final PBUInt32Field uint32_group_open_appid;
        public final PBUInt32Field uint32_group_type_flag;
        public final PBUInt32Field uint32_security_flag;
        public final PBUInt32Field uint32_source_id;
        public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
        public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_class = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
        public final PBUInt64Field uint64_create_flag = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 96, 106, 114, 122, 130, 138, 146, 154, 162, 168, 176, 186, 192, 200, 208, 218}, new String[]{"uint32_group_code", "uint64_owner_uin", "uint32_group_option", "uint32_group_class", "uint32_group_class_ext", "uint32_group_face", "uint32_app_id", "uint32_group_size", "uint64_create_flag", "string_group_name", "uint32_conf_uin", "uint32_check_limit_flag", "string_group_memo", "string_group_finger_memo", "string_group_rich_finger_memo", "string_question", "string_answer", "string_sign", "msg_client_info", "msg_group_geo_info", "uint32_group_type_flag", "uint32_group_face_flag", "type_value_info", "uint32_group_open_appid", "uint32_security_flag", "uint32_source_id", "msg_channel_info"}, new Object[]{0, 0L, 0, 0, 0, 0, 0, 0, 0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, null, null, 0, 0, null, 0, 0, 0, null}, cmd0x8a1$CreateGroupInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x8a1.cmd0x8a1$ChannelInfo] */
        /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.oidb.cmd0x8a1.cmd0x8a1$ClientInfo] */
        /* JADX WARN: Type inference failed for: r1v6, types: [tencent.im.oidb.cmd0x8a1.cmd0x8a1$GroupGeoInfo] */
        /* JADX WARN: Type inference failed for: r1v9, types: [tencent.im.oidb.cmd0x8a1.cmd0x8a1$TypeValues] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.string_group_name = PBField.initBytes(byteStringMicro);
            this.uint32_conf_uin = PBField.initUInt32(0);
            this.uint32_check_limit_flag = PBField.initUInt32(0);
            this.string_group_memo = PBField.initBytes(byteStringMicro);
            this.string_group_finger_memo = PBField.initBytes(byteStringMicro);
            this.string_group_rich_finger_memo = PBField.initBytes(byteStringMicro);
            this.string_question = PBField.initBytes(byteStringMicro);
            this.string_answer = PBField.initBytes(byteStringMicro);
            this.string_sign = PBField.initBytes(byteStringMicro);
            this.msg_client_info = new MessageMicro<cmd0x8a1$ClientInfo>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$ClientInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_pub_no", "uint32_version", "uint32_app_id", "string_inst_id"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY}, cmd0x8a1$ClientInfo.class);
                public final PBUInt32Field uint32_pub_no = PBField.initUInt32(0);
                public final PBUInt32Field uint32_version = PBField.initUInt32(0);
                public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
                public final PBBytesField string_inst_id = PBField.initBytes(ByteStringMicro.EMPTY);
            };
            this.msg_group_geo_info = new MessageMicro<cmd0x8a1$GroupGeoInfo>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$GroupGeoInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_city_id", "uint64_longtitude", "uint64_latitude", "string_geo_content", "uint64_poi_id"}, new Object[]{0, 0L, 0L, ByteStringMicro.EMPTY, 0L}, cmd0x8a1$GroupGeoInfo.class);
                public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
                public final PBUInt64Field uint64_longtitude = PBField.initUInt64(0);
                public final PBUInt64Field uint64_latitude = PBField.initUInt64(0);
                public final PBBytesField string_geo_content = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0);
            };
            this.uint32_group_type_flag = PBField.initUInt32(0);
            this.uint32_group_face_flag = PBField.initUInt32(0);
            this.type_value_info = new MessageMicro<cmd0x8a1$TypeValues>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$TypeValues
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"type_value"}, new Object[]{null}, cmd0x8a1$TypeValues.class);
                public final PBRepeatMessageField<cmd0x8a1$StructTypeValue> type_value = PBField.initRepeatMessage(cmd0x8a1$StructTypeValue.class);
            };
            this.uint32_group_open_appid = PBField.initUInt32(0);
            this.uint32_security_flag = PBField.initUInt32(0);
            this.uint32_source_id = PBField.initUInt32(0);
            this.msg_channel_info = new MessageMicro<cmd0x8a1$ChannelInfo>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$ChannelInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_channel_id"}, new Object[]{0L}, cmd0x8a1$ChannelInfo.class);
                public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
            };
        }
    };
    public cmd0x8a1$SelectGroupCodeInfo msg_select_group_code_info = new MessageMicro<cmd0x8a1$SelectGroupCodeInfo>() { // from class: tencent.im.oidb.cmd0x8a1.cmd0x8a1$SelectGroupCodeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_owner_uin"}, new Object[]{0L}, cmd0x8a1$SelectGroupCodeInfo.class);
        public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);
    };
}
