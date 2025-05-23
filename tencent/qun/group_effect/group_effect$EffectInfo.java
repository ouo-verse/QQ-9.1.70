package tencent.qun.group_effect;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$EffectInfo extends MessageMicro<group_effect$EffectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 114, 122, 130, 138, 146, 808, 816}, new String[]{QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID, "name", "wording", "get_mode", "svip_level", "group_level", "price", "gif_url", "pic_url", "mp4_url", "duration", "status", "sort_num", "attr_id", "small_pic_url", "bg_pic_url", "spirit_url", "spirit_config", RemoteMessageConst.TTL, "user_config_status"}, new Object[]{0, "", "", 0, 0, 0, 0, "", "", "", 0, 0, 0, "", "", "", "", "", 0, Boolean.FALSE}, group_effect$EffectInfo.class);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field get_mode = PBField.initUInt32(0);
    public final PBUInt32Field svip_level = PBField.initUInt32(0);
    public final PBUInt32Field group_level = PBField.initUInt32(0);
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBStringField gif_url = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField mp4_url = PBField.initString("");
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field sort_num = PBField.initUInt32(0);
    public final PBStringField attr_id = PBField.initString("");
    public final PBStringField small_pic_url = PBField.initString("");
    public final PBStringField bg_pic_url = PBField.initString("");
    public final PBStringField spirit_url = PBField.initString("");
    public final PBStringField spirit_config = PBField.initString("");
    public final PBInt32Field ttl = PBField.initInt32(0);
    public final PBBoolField user_config_status = PBField.initBool(false);
}
