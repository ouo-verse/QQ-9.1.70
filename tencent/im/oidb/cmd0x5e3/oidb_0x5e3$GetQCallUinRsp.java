package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import com.tencent.xweb.internal.ConstValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5e3$GetQCallUinRsp extends MessageMicro<oidb_0x5e3$GetQCallUinRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gsm;
    public final PBBytesField bytes_new_gsm;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_photo_ids;
    public final PBBytesField bytes_qq_auto_remark;
    public final PBBytesField bytes_recycle_ip;
    public final PBBytesField bytes_reg_ip;
    public final PBBytesField bytes_remark;
    public final PBUInt32Field uint32_addrlist_time;
    public final PBUInt32Field uint32_bind_qq_netstatus;
    public final PBUInt32Field uint32_birthday;
    public final PBUInt32Field uint32_close_friend_recommend_sound;
    public final PBUInt32Field uint32_contact_qq_netstatus;
    public final PBUInt32Field uint32_frozing_flag;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_identity;
    public final PBUInt32Field uint32_if_pop_up;
    public final PBUInt32Field uint32_in_use_flag;
    public final PBUInt32Field uint32_is_call_free;
    public final PBUInt32Field uint32_is_ever_pstn;
    public final PBUInt32Field uint32_login_fobid_flag;
    public final PBUInt32Field uint32_mask_gsm;
    public final PBUInt32Field uint32_netstatus;
    public final PBUInt32Field uint32_next_photo_id;
    public final PBUInt32Field uint32_normal_all_free_time;
    public final PBUInt32Field uint32_normal_left_free_time;
    public final PBUInt32Field uint32_pre_recycle_flag;
    public final PBUInt32Field uint32_profile_card_type;
    public final PBUInt32Field uint32_pstn;
    public final PBUInt32Field uint32_qq;
    public final PBUInt32Field uint32_qq_is_call_free;
    public final PBUInt32Field uint32_qq_netstatus;
    public final PBUInt32Field uint32_recycle_flag;
    public final PBUInt32Field uint32_recycle_time;
    public final PBUInt32Field uint32_reg_time;
    public final PBUInt32Field uint32_search_fobid_flag;
    public final PBUInt32Field uint32_used_free_time;
    public final PBUInt32Field uint32_vip_all_free_time;
    public final PBUInt32Field uint32_vip_left_free_time;
    public final PBUInt64Field uint64_contact_qq;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 162, 168, 176, 240, 248, 256, 264, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 320, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 336, 346, 402, 424, 80002, 80008, ConstValue.INVOKE_RUNTIME_ID_XPROFILE_FORCE_FLUSH, ConstValue.INVOKE_RUNTIME_ID_SET_PROXY_OVERRIDE, ConstValue.INVOKE_RUNTIME_ID_STOP_REMOTE_DEBUG, 80040, 80048, 80056, 80064, 80072, 80080, 80088, 80096, 80104, 80112, 80122, 80130, 80136, 80144, 80152, 80160, 80168, 80176, 80184}, new String[]{"uint64_uin", "bytes_nick", "uint32_gender", "uint32_birthday", "uint32_in_use_flag", "uint32_pre_recycle_flag", "uint32_recycle_flag", "uint32_frozing_flag", "uint32_search_fobid_flag", "uint32_login_fobid_flag", "uint32_close_friend_recommend_sound", "uint32_reg_time", "bytes_reg_ip", "uint32_recycle_time", "bytes_recycle_ip", "bytes_photo_ids", "uint32_next_photo_id", "bytes_remark", "uint32_netstatus", "uint32_qq", "bytes_gsm", "uint32_mask_gsm", "uint32_is_call_free", "uint32_qq_netstatus", "uint32_qq_is_call_free", "uint32_pstn", "uint32_is_ever_pstn", "uint32_vip_all_free_time", "uint32_vip_left_free_time", "uint32_normal_all_free_time", "uint32_normal_left_free_time", "uint32_used_free_time", "bytes_new_gsm", "bytes_qq_auto_remark", "uint32_profile_card_type", "uint32_if_pop_up", "uint32_addrlist_time", "uint32_identity", "uint64_contact_qq", "uint32_bind_qq_netstatus", "uint32_contact_qq_netstatus"}, new Object[]{0L, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0L, 0, 0}, oidb_0x5e3$GetQCallUinRsp.class);
    }

    public oidb_0x5e3$GetQCallUinRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_birthday = PBField.initUInt32(0);
        this.uint32_in_use_flag = PBField.initUInt32(0);
        this.uint32_pre_recycle_flag = PBField.initUInt32(0);
        this.uint32_recycle_flag = PBField.initUInt32(0);
        this.uint32_frozing_flag = PBField.initUInt32(0);
        this.uint32_search_fobid_flag = PBField.initUInt32(0);
        this.uint32_login_fobid_flag = PBField.initUInt32(0);
        this.uint32_close_friend_recommend_sound = PBField.initUInt32(0);
        this.uint32_reg_time = PBField.initUInt32(0);
        this.bytes_reg_ip = PBField.initBytes(byteStringMicro);
        this.uint32_recycle_time = PBField.initUInt32(0);
        this.bytes_recycle_ip = PBField.initBytes(byteStringMicro);
        this.bytes_photo_ids = PBField.initBytes(byteStringMicro);
        this.uint32_next_photo_id = PBField.initUInt32(0);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_netstatus = PBField.initUInt32(0);
        this.uint32_qq = PBField.initUInt32(0);
        this.bytes_gsm = PBField.initBytes(byteStringMicro);
        this.uint32_mask_gsm = PBField.initUInt32(0);
        this.uint32_is_call_free = PBField.initUInt32(0);
        this.uint32_qq_netstatus = PBField.initUInt32(0);
        this.uint32_qq_is_call_free = PBField.initUInt32(0);
        this.uint32_pstn = PBField.initUInt32(0);
        this.uint32_is_ever_pstn = PBField.initUInt32(0);
        this.uint32_vip_all_free_time = PBField.initUInt32(0);
        this.uint32_vip_left_free_time = PBField.initUInt32(0);
        this.uint32_normal_all_free_time = PBField.initUInt32(0);
        this.uint32_normal_left_free_time = PBField.initUInt32(0);
        this.uint32_used_free_time = PBField.initUInt32(0);
        this.bytes_new_gsm = PBField.initBytes(byteStringMicro);
        this.bytes_qq_auto_remark = PBField.initBytes(byteStringMicro);
        this.uint32_profile_card_type = PBField.initUInt32(0);
        this.uint32_if_pop_up = PBField.initUInt32(0);
        this.uint32_addrlist_time = PBField.initUInt32(0);
        this.uint32_identity = PBField.initUInt32(0);
        this.uint64_contact_qq = PBField.initUInt64(0L);
        this.uint32_bind_qq_netstatus = PBField.initUInt32(0);
        this.uint32_contact_qq_netstatus = PBField.initUInt32(0);
    }
}
