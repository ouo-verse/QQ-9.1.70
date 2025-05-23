package tencent.im.onlinestatus;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusShareInfo$SetShareInfoReq extends MessageMicro<OnlineStatusShareInfo$SetShareInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{null}, OnlineStatusShareInfo$SetShareInfoReq.class);
    public OnlineStatusShareInfo$ShareInfoItem item = new OnlineStatusShareInfo$ShareInfoItem();
}
