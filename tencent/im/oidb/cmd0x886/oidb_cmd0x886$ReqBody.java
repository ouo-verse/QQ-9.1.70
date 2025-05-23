package tencent.im.oidb.cmd0x886;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x886$ReqBody extends MessageMicro<oidb_cmd0x886$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"uint64_uin", "msg_phone_info", "msg_ad_info", "bytes_uuid", "uint64_client_time", "enum_ad_display"}, new Object[]{0L, null, null, ByteStringMicro.EMPTY, 0L, 2}, oidb_cmd0x886$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0x886$PhoneInfo msg_phone_info = new MessageMicro<oidb_cmd0x886$PhoneInfo>() { // from class: tencent.im.oidb.cmd0x886.oidb_cmd0x886$PhoneInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_appid;
        public final PBBytesField bytes_client_ip;
        public final PBBytesField bytes_client_mac;
        public final PBBytesField bytes_muid;
        public final PBBytesField bytes_os_ver;
        public final PBBytesField bytes_qq_ver;
        public final PBUInt32Field uint32_carrier;
        public final PBUInt32Field uint32_conn;
        public final PBUInt32Field uint32_muid_type;
        public final PBUInt32Field uint32_os_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 74, 80}, new String[]{"bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_client_mac", "bytes_appid", "uint32_os_type"}, new Object[]{byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_cmd0x886$PhoneInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_muid = PBField.initBytes(byteStringMicro);
            this.uint32_conn = PBField.initUInt32(0);
            this.uint32_carrier = PBField.initUInt32(0);
            this.uint32_muid_type = PBField.initUInt32(0);
            this.bytes_os_ver = PBField.initBytes(byteStringMicro);
            this.bytes_qq_ver = PBField.initBytes(byteStringMicro);
            this.bytes_client_ip = PBField.initBytes(byteStringMicro);
            this.bytes_client_mac = PBField.initBytes(byteStringMicro);
            this.bytes_appid = PBField.initBytes(byteStringMicro);
            this.uint32_os_type = PBField.initUInt32(0);
        }
    };
    public oidb_cmd0x886$AdInfo msg_ad_info = new MessageMicro<oidb_cmd0x886$AdInfo>() { // from class: tencent.im.oidb.cmd0x886.oidb_cmd0x886$AdInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_apurl;
        public final PBBytesField bytes_button_url;
        public final PBBytesField bytes_cl;
        public final PBBytesField bytes_corporate_image_name;
        public final PBBytesField bytes_corporate_logo;
        public final PBBytesField bytes_corporation_name;
        public final PBBytesField bytes_customized_invoke_url;
        public final PBBytesField bytes_desc;
        public final PBBytesField bytes_ext;
        public final PBBytesField bytes_img;
        public final PBBytesField bytes_img_s;
        public final PBBytesField bytes_price;
        public final PBBytesField bytes_product_id;
        public final PBBytesField bytes_rl;
        public final PBBytesField bytes_trace_id;
        public final PBBytesField bytes_txt;
        public final PBBytesField bytes_via;
        public final PBBytesField bytes_video_url;
        public final PBBytesField bytes_view_id;
        public final PBEnumField enum_ad_layout;
        public final PBEnumField enum_pos_layout;
        public final PBEnumField enum_report_type;
        public final PBInt32Field int32_kd_pos;
        public final PBInt32Field int32_product_type;
        public oidb_cmd0x886$VideoPlayInfo msg_video_play_info;
        public final PBUInt32Field uint32_ad_material_id;
        public final PBUInt32Field uint32_ad_type;
        public final PBUInt32Field uint32_cost_type;
        public final PBUInt32Field uint32_dis_channel;
        public final PBUInt32Field uint32_duration;
        public final PBUInt64Field uint64_ad_uin;
        public final PBUInt64Field uint64_aid;
        public final PBUInt64Field uint64_channel_id;
        public final PBUInt64Field uint64_neg_fb_type_id;
        public final PBUInt64Field uint64_pos_id;
        public final PBUInt64Field uint64_pull_time;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 112, 120, 130, 138, 146, 154, 162, 168, 178, 186, 192, 200, 210, 218, 226, 234, 240, 248, 258, 264, 274, FilterEnum.MIC_PTU_BAIXI, 288}, new String[]{"bytes_trace_id", "uint64_pull_time", "enum_report_type", "bytes_apurl", "bytes_rl", "bytes_view_id", "uint64_neg_fb_type_id", "uint64_pos_id", "uint64_channel_id", "int32_kd_pos", "bytes_cl", "enum_pos_layout", "bytes_product_id", "int32_product_type", "uint32_ad_type", "bytes_price", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "uint64_aid", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "enum_ad_layout", "uint32_ad_material_id", "bytes_via", "uint32_dis_channel", "bytes_button_url", "msg_video_play_info", "uint32_duration"}, new Object[]{byteStringMicro, 0L, 1, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L, 0L, 0, byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0, byteStringMicro, null, 0}, oidb_cmd0x886$AdInfo.class);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0x886.oidb_cmd0x886$VideoPlayInfo] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_trace_id = PBField.initBytes(byteStringMicro);
            this.uint64_pull_time = PBField.initUInt64(0L);
            this.enum_report_type = PBField.initEnum(1);
            this.bytes_apurl = PBField.initBytes(byteStringMicro);
            this.bytes_rl = PBField.initBytes(byteStringMicro);
            this.bytes_view_id = PBField.initBytes(byteStringMicro);
            this.uint64_neg_fb_type_id = PBField.initUInt64(0L);
            this.uint64_pos_id = PBField.initUInt64(0L);
            this.uint64_channel_id = PBField.initUInt64(0L);
            this.int32_kd_pos = PBField.initInt32(0);
            this.bytes_cl = PBField.initBytes(byteStringMicro);
            this.enum_pos_layout = PBField.initEnum(0);
            this.bytes_product_id = PBField.initBytes(byteStringMicro);
            this.int32_product_type = PBField.initInt32(0);
            this.uint32_ad_type = PBField.initUInt32(0);
            this.bytes_price = PBField.initBytes(byteStringMicro);
            this.bytes_customized_invoke_url = PBField.initBytes(byteStringMicro);
            this.bytes_corporation_name = PBField.initBytes(byteStringMicro);
            this.bytes_corporate_image_name = PBField.initBytes(byteStringMicro);
            this.bytes_corporate_logo = PBField.initBytes(byteStringMicro);
            this.uint64_ad_uin = PBField.initUInt64(0L);
            this.bytes_ext = PBField.initBytes(byteStringMicro);
            this.bytes_video_url = PBField.initBytes(byteStringMicro);
            this.uint32_cost_type = PBField.initUInt32(0);
            this.uint64_aid = PBField.initUInt64(0L);
            this.bytes_img = PBField.initBytes(byteStringMicro);
            this.bytes_img_s = PBField.initBytes(byteStringMicro);
            this.bytes_txt = PBField.initBytes(byteStringMicro);
            this.bytes_desc = PBField.initBytes(byteStringMicro);
            this.enum_ad_layout = PBField.initEnum(0);
            this.uint32_ad_material_id = PBField.initUInt32(0);
            this.bytes_via = PBField.initBytes(byteStringMicro);
            this.uint32_dis_channel = PBField.initUInt32(0);
            this.bytes_button_url = PBField.initBytes(byteStringMicro);
            this.msg_video_play_info = new MessageMicro<oidb_cmd0x886$VideoPlayInfo>() { // from class: tencent.im.oidb.cmd0x886.oidb_cmd0x886$VideoPlayInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint32_bt", "uint32_et", "uint32_bf", "uint32_ef", "uint32_pp", "uint32_pa", "uint32_pb"}, new Object[]{0, 0, 0, 0, 0, 0, 0}, oidb_cmd0x886$VideoPlayInfo.class);
                public final PBUInt32Field uint32_bt = PBField.initUInt32(0);
                public final PBUInt32Field uint32_et = PBField.initUInt32(0);
                public final PBUInt32Field uint32_bf = PBField.initUInt32(0);
                public final PBUInt32Field uint32_ef = PBField.initUInt32(0);
                public final PBUInt32Field uint32_pp = PBField.initUInt32(0);
                public final PBUInt32Field uint32_pa = PBField.initUInt32(0);
                public final PBUInt32Field uint32_pb = PBField.initUInt32(0);
            };
            this.uint32_duration = PBField.initUInt32(0);
        }
    };
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_client_time = PBField.initUInt64(0);
    public final PBEnumField enum_ad_display = PBField.initEnum(2);
}
