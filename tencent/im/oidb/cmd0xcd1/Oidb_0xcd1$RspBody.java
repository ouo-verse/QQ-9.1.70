package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xcd1$RspBody extends MessageMicro<Oidb_0xcd1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"get_pack_rsp"}, new Object[]{null}, Oidb_0xcd1$RspBody.class);
    public Oidb_0xcd1$GetPackageShopRsp get_pack_rsp = new MessageMicro<Oidb_0xcd1$GetPackageShopRsp>() { // from class: tencent.im.oidb.cmd0xcd1.Oidb_0xcd1$GetPackageShopRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_stock", "empty_package_page"}, new Object[]{null, null}, Oidb_0xcd1$GetPackageShopRsp.class);
        public final PBRepeatMessageField<Oidb_0xcd1$StockItem> msg_stock = PBField.initRepeatMessage(Oidb_0xcd1$StockItem.class);
        public Oidb_0xcd1$EmptyPackagePage empty_package_page = new MessageMicro<Oidb_0xcd1$EmptyPackagePage>() { // from class: tencent.im.oidb.cmd0xcd1.Oidb_0xcd1$EmptyPackagePage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"enable", "wording", "jump_wording", "jump_url"}, new Object[]{0, "", "", ""}, Oidb_0xcd1$EmptyPackagePage.class);
            public final PBInt32Field enable = PBField.initInt32(0);
            public final PBStringField wording = PBField.initString("");
            public final PBStringField jump_wording = PBField.initString("");
            public final PBStringField jump_url = PBField.initString("");
        };
    };
}
