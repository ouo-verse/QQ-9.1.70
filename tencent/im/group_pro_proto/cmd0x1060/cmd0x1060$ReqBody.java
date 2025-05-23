package tencent.im.group_pro_proto.cmd0x1060;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1060$ReqBody extends MessageMicro<cmd0x1060$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72}, new String[]{"uint64_guild_id", "pass_card_code", "invite_code", "uins", "msg", "qq_group_uin", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "share_num"}, new Object[]{0L, 0, 0, 0L, "", 0L, 0, 0, 0}, cmd0x1060$ReqBody.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f435941msg;
    public final PBRepeatField<Long> qq_group_uin;
    public final PBUInt32Field share_num;
    public final PBUInt32Field share_type;
    public final PBUInt32Field source_type;
    public final PBRepeatField<Long> uins;
    public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    public final PBUInt32Field pass_card_code = PBField.initUInt32(0);
    public final PBUInt32Field invite_code = PBField.initUInt32(0);

    public cmd0x1060$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uins = PBField.initRepeat(pBUInt64Field);
        this.f435941msg = PBField.initString("");
        this.qq_group_uin = PBField.initRepeat(pBUInt64Field);
        this.source_type = PBField.initUInt32(0);
        this.share_type = PBField.initUInt32(0);
        this.share_num = PBField.initUInt32(0);
    }
}
