package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$CommonExtensionInfo extends MessageMicro<StorageNTSdkExtInfo$CommonExtensionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{FSUploadConst.KEY_FAKEFEED_CLIENTKEY}, new Object[]{""}, StorageNTSdkExtInfo$CommonExtensionInfo.class);
    public final PBStringField mobile_fakefeeds_clientkey = PBField.initString("");
}
