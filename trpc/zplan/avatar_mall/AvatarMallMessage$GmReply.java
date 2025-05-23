package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.zplan.CsCommon$RspHeader;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GmReply extends MessageMicro<AvatarMallMessage$GmReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"rsp_header", "gm_cmd", "register_new_user_reply", "add_one_item_reply", "add_all_items_reply", "add_coin_reply"}, new Object[]{null, "", null, null, null, null}, AvatarMallMessage$GmReply.class);
    public CsCommon$RspHeader rsp_header = new CsCommon$RspHeader();
    public final PBStringField gm_cmd = PBField.initString("");
    public AvatarMallMessage$GMRegisterNewUserReply register_new_user_reply = new MessageMicro<AvatarMallMessage$GMRegisterNewUserReply>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMRegisterNewUserReply
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvatarMallMessage$GMRegisterNewUserReply.class);
    };
    public AvatarMallMessage$GMAddOneItemReply add_one_item_reply = new MessageMicro<AvatarMallMessage$GMAddOneItemReply>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddOneItemReply
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvatarMallMessage$GMAddOneItemReply.class);
    };
    public AvatarMallMessage$GMAddAllItemsReply add_all_items_reply = new MessageMicro<AvatarMallMessage$GMAddAllItemsReply>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddAllItemsReply
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"item_id"}, new Object[]{0L}, AvatarMallMessage$GMAddAllItemsReply.class);
        public final PBRepeatField<Long> item_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public AvatarMallMessage$GMAddCoinReply add_coin_reply = new MessageMicro<AvatarMallMessage$GMAddCoinReply>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddCoinReply
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AvatarMallMessage$GMAddCoinReply.class);
    };
}
