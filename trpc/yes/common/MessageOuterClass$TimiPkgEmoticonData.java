package trpc.yes.common;

import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* loaded from: classes30.dex */
public final class MessageOuterClass$TimiPkgEmoticonData extends MessageMicro<MessageOuterClass$TimiPkgEmoticonData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField epId = PBField.initString("");
    public final PBStringField eId = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField encryptKey = PBField.initString("");
    public final PBBoolField isSound = PBField.initBool(false);
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBInt32Field jobType = PBField.initInt32(0);
    public final PBStringField keyword = PBField.initString("");
    public final PBStringField keywords = PBField.initString("");
    public final PBStringField character = PBField.initString("");
    public final PBInt32Field extensionWidth = PBField.initInt32(0);
    public final PBInt32Field extensionHeight = PBField.initInt32(0);
    public final PBBoolField isAPNG = PBField.initBool(false);
    public final PBInt32Field imageType = PBField.initInt32(0);

    static {
        String[] strArr = {EmojiManagerServiceProxy.EPID, "eId", "name", "encryptKey", ThemeReporter.THEME_ISSOUND, "width", "height", "jobType", "keyword", "keywords", "character", "extensionWidth", "extensionHeight", "isAPNG", NodeProps.CUSTOM_PROP_IMAGE_TYPE};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 96, 104, 112, 120}, strArr, new Object[]{"", "", "", "", bool, 0, 0, 0, "", "", "", 0, 0, bool, 0}, MessageOuterClass$TimiPkgEmoticonData.class);
    }
}
