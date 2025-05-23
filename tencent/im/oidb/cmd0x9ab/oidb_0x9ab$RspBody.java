package tencent.im.oidb.cmd0x9ab;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9ab$RspBody extends MessageMicro<oidb_0x9ab$RspBody> {
    public static final int ITEM_FIELD_NUMBER = 2;
    public static final int LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"list", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{null, null}, oidb_0x9ab$RspBody.class);
    public oidb_0x9ab$GroupTabList list = new oidb_0x9ab$GroupTabList();
    public oidb_0x9ab$TabItem item = new oidb_0x9ab$TabItem();
}
