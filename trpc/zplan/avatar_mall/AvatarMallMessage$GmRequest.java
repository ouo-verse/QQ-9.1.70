package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$GmRequest extends MessageMicro<AvatarMallMessage$GmRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"gm_cmd", "register_new_user_request", "add_one_item_request", "add_all_items_request", "add_coin_request"}, new Object[]{"", null, null, null, null}, AvatarMallMessage$GmRequest.class);
    public final PBStringField gm_cmd = PBField.initString("");
    public AvatarMallMessage$GMRegisterNewUserRequest register_new_user_request = new MessageMicro<AvatarMallMessage$GMRegisterNewUserRequest>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMRegisterNewUserRequest
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uin"}, new Object[]{""}, AvatarMallMessage$GMRegisterNewUserRequest.class);
        public final PBStringField uin = PBField.initString("");
    };
    public AvatarMallMessage$GMAddOneItemRequest add_one_item_request = new MessageMicro<AvatarMallMessage$GMAddOneItemRequest>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddOneItemRequest
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uin", "item_id"}, new Object[]{"", 0}, AvatarMallMessage$GMAddOneItemRequest.class);
        public final PBStringField uin = PBField.initString("");
        public final PBUInt32Field item_id = PBField.initUInt32(0);
    };
    public AvatarMallMessage$GMAddAllItemsRequest add_all_items_request = new MessageMicro<AvatarMallMessage$GMAddAllItemsRequest>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddAllItemsRequest
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uin"}, new Object[]{""}, AvatarMallMessage$GMAddAllItemsRequest.class);
        public final PBStringField uin = PBField.initString("");
    };
    public AvatarMallMessage$GMAddCoinRequest add_coin_request = new MessageMicro<AvatarMallMessage$GMAddCoinRequest>() { // from class: trpc.zplan.avatar_mall.AvatarMallMessage$GMAddCoinRequest
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uin", "add_diamond_num", "add_bean_num"}, new Object[]{"", 0L, 0L}, AvatarMallMessage$GMAddCoinRequest.class);
        public final PBStringField uin = PBField.initString("");
        public final PBUInt64Field add_diamond_num = PBField.initUInt64(0);
        public final PBUInt64Field add_bean_num = PBField.initUInt64(0);
    };
}
