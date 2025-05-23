package tencent.im.oidb.cmd0xc76;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc76$Setting extends MessageMicro<oidb_cmd0xc76$Setting> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"desc", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{"", null}, oidb_cmd0xc76$Setting.class);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xc76$Item> item = PBField.initRepeatMessage(oidb_cmd0xc76$Item.class);
}
