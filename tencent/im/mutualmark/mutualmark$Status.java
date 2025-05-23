package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$Status extends MessageMicro<mutualmark$Status> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field src_uin = PBField.initUInt64(0);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
    public final PBUInt64Field sub_level = PBField.initUInt64(0);
    public final PBFloatField count = PBField.initFloat(0.0f);
    public final PBUInt64Field act_days = PBField.initUInt64(0);
    public final PBUInt64Field lightup_days = PBField.initUInt64(0);
    public final PBUInt64Field last_act_time = PBField.initUInt64(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt64Field icon_status_end_time = PBField.initUInt64(0);
    public final PBBytesField resource_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_wearing = PBField.initBool(false);
    public final PBBoolField is_lightup = PBField.initBool(false);
    public final PBBoolField is_degrade = PBField.initBool(false);
    public final PBBoolField is_prefetch = PBField.initBool(false);
    public final PBBoolField is_lightoff = PBField.initBool(false);
    public mutualmark$Recover recover = new MessageMicro<mutualmark$Recover>() { // from class: tencent.im.mutualmark.mutualmark$Recover
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], mutualmark$Recover.class);
    };
    public final PBBoolField is_once = PBField.initBool(false);
    public final PBBoolField is_new = PBField.initBool(false);
    public final PBUInt64Field lightup_time = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435958id = PBField.initUInt64(0);
    public final PBRepeatMessageField<mutualmark$Button> action = PBField.initRepeatMessage(mutualmark$Button.class);
    public mutualmark$SpecialWordInfo special_word = new mutualmark$SpecialWordInfo();
    public final PBUInt64Field group_lightup_count = PBField.initUInt64(0);
    public final PBUInt64Field group_total = PBField.initUInt64(0);
    public final PBStringField extend_name = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 56, 64, 74, 80, 90, 96, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 186, 192, 200, 210}, new String[]{"src_uin", "dst_uin", "level", "sub_level", "count", "act_days", "lightup_days", "last_act_time", "icon_url", "icon_status_end_time", "resource_info", "is_wearing", "is_lightup", "is_degrade", "is_prefetch", "is_lightoff", "recover", "is_once", "is_new", "lightup_time", "id", "action", "special_word", "group_lightup_count", "group_total", "extend_name"}, new Object[]{0L, 0L, 0L, 0L, Float.valueOf(0.0f), 0L, 0L, 0L, "", 0L, ByteStringMicro.EMPTY, bool, bool, bool, bool, bool, null, bool, bool, 0L, 0L, null, null, 0L, 0L, ""}, mutualmark$Status.class);
    }
}
