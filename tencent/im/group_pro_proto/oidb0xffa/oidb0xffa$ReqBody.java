package tencent.im.group_pro_proto.oidb0xffa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb0xffa$ReqBody extends MessageMicro<oidb0xffa$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56, 66, 72, 82}, new String[]{"ark_message", "guild_info", "leave_message", "uins", "group_codes", "from_guild_infos", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "feed_id", "is_private_msg", "share_atta_data"}, new Object[]{null, null, "", 0L, 0L, null, 0, "", Boolean.FALSE, ByteStringMicro.EMPTY}, oidb0xffa$ReqBody.class);
    public final PBStringField feed_id;
    public oidb0xffa$GuildInfo from_guild_infos;
    public final PBRepeatField<Long> group_codes;
    public final PBBoolField is_private_msg;
    public final PBBytesField share_atta_data;
    public final PBEnumField share_type;
    public final PBRepeatField<Long> uins;
    public oidb0xffa$ArkMessage ark_message = new oidb0xffa$ArkMessage();
    public final PBRepeatMessageField<oidb0xffa$GuildInfo> guild_info = PBField.initRepeatMessage(oidb0xffa$GuildInfo.class);
    public final PBStringField leave_message = PBField.initString("");

    public oidb0xffa$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uins = PBField.initRepeat(pBUInt64Field);
        this.group_codes = PBField.initRepeat(pBUInt64Field);
        this.from_guild_infos = new oidb0xffa$GuildInfo();
        this.share_type = PBField.initEnum(0);
        this.feed_id = PBField.initString("");
        this.is_private_msg = PBField.initBool(false);
        this.share_atta_data = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
