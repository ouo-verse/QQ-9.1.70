package tencent.im.oidb.cmd0x9e4;

import appoint.define.appoint_define$CommonLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9e4$UdcUinData extends MessageMicro<cmd0x9e4$UdcUinData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_basic_cli_flag;
    public final PBBytesField bytes_basic_svr_flag;
    public final PBBytesField bytes_birthday;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_city_id;
    public final PBBytesField bytes_country;
    public final PBBytesField bytes_full_age;
    public final PBBytesField bytes_full_birthday;
    public final PBBytesField bytes_mss1_service;
    public final PBBytesField bytes_mss2_identity;
    public final PBBytesField bytes_mss3_bitmapextra;
    public final PBBytesField bytes_music_gene;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_openid;
    public final PBBytesField bytes_province;
    public final PBBytesField bytes_stranger_declare;
    public final PBBytesField bytes_stranger_nick;
    public appoint_define$CommonLabel msg_common_label;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_allow;
    public final PBUInt32Field uint32_auth_flag;
    public final PBUInt32Field uint32_bubble_id;
    public final PBUInt32Field uint32_cface_flag;
    public final PBUInt32Field uint32_charm;
    public final PBUInt32Field uint32_charm_level;
    public final PBUInt32Field uint32_charm_shown;
    public final PBUInt32Field uint32_city_zone_id;
    public final PBUInt32Field uint32_clear_gps;
    public final PBUInt32Field uint32_close_fresh_push_flag;
    public final PBUInt32Field uint32_common_place1;
    public final PBUInt32Field uint32_constellation;
    public final PBUInt32Field uint32_ext_flag;
    public final PBUInt32Field uint32_face_id;
    public final PBUInt32Field uint32_forbid_flag;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_gift_activated_flag;
    public final PBUInt32Field uint32_god_flag;
    public final PBUInt32Field uint32_god_forbid;
    public final PBUInt32Field uint32_group_mem_credit_flag;
    public final PBUInt32Field uint32_lang1;
    public final PBUInt32Field uint32_lang2;
    public final PBUInt32Field uint32_lang3;
    public final PBUInt32Field uint32_lflag;
    public final PBUInt32Field uint32_love_status;
    public final PBUInt32Field uint32_mss_update_time;
    public final PBUInt32Field uint32_oin;
    public final PBUInt32Field uint32_profession;
    public final PBUInt32Field uint32_pub_number_flag;
    public final PBUInt32Field uint32_simple_update_time;
    public final PBUInt32Field uint32_vip_flag;
    public final PBUInt32Field uint32_vote_flag;
    public final PBUInt64Field uint64_face_addon_id;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 34, 160018, 160026, 160034, 160072, 160112, 160120, 160162, 160176, 160216, 160242, 160250, 160258, 160264, 160272, 160280, 160296, 160328, 160448, 160472, 168010, 168018, 168024, 168032, 168050, 168058, 208034, 208042, 208080, 208088, 216176, 216200, 216210, 216274, 216282, 216288, 216296, 216416, 322592, 324448, 334048, 334264, 334272, 334280, 334432, 334440, 334456, 335600, 335784, 335944, 335976, 440002}, new String[]{"uint64_uin", "bytes_openid", "bytes_nick", "bytes_country", "bytes_province", "uint32_gender", "uint32_allow", "uint32_face_id", "bytes_city", "uint32_constellation", "uint32_common_place1", "bytes_mss3_bitmapextra", "bytes_birthday", "bytes_city_id", "uint32_lang1", "uint32_lang2", "uint32_lang3", "uint32_age", "uint32_city_zone_id", "uint32_oin", "uint32_bubble_id", "bytes_mss2_identity", "bytes_mss1_service", "uint32_lflag", "uint32_ext_flag", "bytes_basic_svr_flag", "bytes_basic_cli_flag", "bytes_full_birthday", "bytes_full_age", "uint32_simple_update_time", "uint32_mss_update_time", "uint32_group_mem_credit_flag", "uint64_face_addon_id", "bytes_music_gene", "bytes_stranger_nick", "bytes_stranger_declare", "uint32_love_status", "uint32_profession", "uint32_charm", "uint32_vote_flag", "uint32_cface_flag", "uint32_vip_flag", "uint32_auth_flag", "uint32_forbid_flag", "uint32_gift_activated_flag", "uint32_god_forbid", "uint32_god_flag", "uint32_clear_gps", "uint32_charm_level", "uint32_charm_shown", "uint32_close_fresh_push_flag", "uint32_pub_number_flag", "msg_common_label"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null}, cmd0x9e4$UdcUinData.class);
    }

    public cmd0x9e4$UdcUinData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_openid = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_allow = PBField.initUInt32(0);
        this.uint32_face_id = PBField.initUInt32(0);
        this.uint32_common_place1 = PBField.initUInt32(0);
        this.bytes_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_full_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_full_age = PBField.initBytes(byteStringMicro);
        this.bytes_country = PBField.initBytes(byteStringMicro);
        this.bytes_province = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.uint32_constellation = PBField.initUInt32(0);
        this.bytes_city_id = PBField.initBytes(byteStringMicro);
        this.uint32_city_zone_id = PBField.initUInt32(0);
        this.uint32_lang1 = PBField.initUInt32(0);
        this.uint32_lang2 = PBField.initUInt32(0);
        this.uint32_lang3 = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_oin = PBField.initUInt32(0);
        this.uint32_simple_update_time = PBField.initUInt32(0);
        this.uint32_group_mem_credit_flag = PBField.initUInt32(0);
        this.uint64_face_addon_id = PBField.initUInt64(0L);
        this.uint32_bubble_id = PBField.initUInt32(0);
        this.bytes_music_gene = PBField.initBytes(byteStringMicro);
        this.uint32_lflag = PBField.initUInt32(0);
        this.uint32_ext_flag = PBField.initUInt32(0);
        this.bytes_basic_svr_flag = PBField.initBytes(byteStringMicro);
        this.bytes_basic_cli_flag = PBField.initBytes(byteStringMicro);
        this.bytes_mss1_service = PBField.initBytes(byteStringMicro);
        this.bytes_mss2_identity = PBField.initBytes(byteStringMicro);
        this.bytes_mss3_bitmapextra = PBField.initBytes(byteStringMicro);
        this.uint32_mss_update_time = PBField.initUInt32(0);
        this.bytes_stranger_nick = PBField.initBytes(byteStringMicro);
        this.bytes_stranger_declare = PBField.initBytes(byteStringMicro);
        this.uint32_love_status = PBField.initUInt32(0);
        this.uint32_profession = PBField.initUInt32(0);
        this.uint32_cface_flag = PBField.initUInt32(0);
        this.uint32_vip_flag = PBField.initUInt32(0);
        this.uint32_auth_flag = PBField.initUInt32(0);
        this.uint32_forbid_flag = PBField.initUInt32(0);
        this.uint32_god_forbid = PBField.initUInt32(0);
        this.uint32_god_flag = PBField.initUInt32(0);
        this.uint32_charm = PBField.initUInt32(0);
        this.uint32_charm_level = PBField.initUInt32(0);
        this.uint32_charm_shown = PBField.initUInt32(0);
        this.uint32_vote_flag = PBField.initUInt32(0);
        this.uint32_clear_gps = PBField.initUInt32(0);
        this.uint32_gift_activated_flag = PBField.initUInt32(0);
        this.uint32_close_fresh_push_flag = PBField.initUInt32(0);
        this.uint32_pub_number_flag = PBField.initUInt32(0);
        this.msg_common_label = new appoint_define$CommonLabel();
    }
}
