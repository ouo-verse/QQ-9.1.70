package unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchUniteMore$SearchMainGuildChannelItem extends MessageMicro<UnifySearchUniteMore$SearchMainGuildChannelItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90, 96, 106}, new String[]{"status", "cover_url", "title", "sub_title", "icons", "top_label_list", "bottom_label_list", "guild_id", "guild_owner_uin", "join_guild_sig", "query", "join_status", "mixed_label_list"}, new Object[]{0, "", "", "", "", null, null, 0L, 0L, "", "", 0, null}, UnifySearchUniteMore$SearchMainGuildChannelItem.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField cover_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<UnifySearchUniteMore$Label> top_label_list = PBField.initRepeatMessage(UnifySearchUniteMore$Label.class);
    public final PBRepeatMessageField<UnifySearchUniteMore$Label> bottom_label_list = PBField.initRepeatMessage(UnifySearchUniteMore$Label.class);
    public final PBInt64Field guild_id = PBField.initInt64(0);
    public final PBInt64Field guild_owner_uin = PBField.initInt64(0);
    public final PBStringField join_guild_sig = PBField.initString("");
    public final PBStringField query = PBField.initString("");
    public final PBUInt32Field join_status = PBField.initUInt32(0);
    public final PBRepeatMessageField<UnifySearchUniteMore$Label> mixed_label_list = PBField.initRepeatMessage(UnifySearchUniteMore$Label.class);
}
