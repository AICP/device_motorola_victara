# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit some common aicp stuff.
$(call inherit-product, vendor/aicp/config/common_full_phone.mk)

# Inherit from victara device
$(call inherit-product, $(LOCAL_PATH)/device.mk)

# Device identifier. This must come after all inclusions
BUILD_FINGERPRINT := motorola/victara_tmo/victara:5.1/LPE23.32-21.3/5:user/release-keys
PRODUCT_DEVICE := victara
PRODUCT_NAME := aicp_victara
PRODUCT_BRAND := motorola
PRODUCT_MODEL := victara
PRODUCT_MANUFACTURER := motorola

PRODUCT_BUILD_PROP_OVERRIDES += \
    PRODUCT_NAME="MOTO X (2014)" \
    TARGET_DEVICE="victara" \
    PRIVATE_BUILD_DESC="victara_tmo-user 5.1 LPE23.32-21.3 5 release-keys"

PRODUCT_GMS_CLIENTID_BASE := android-motorola

# AICP Device Maintainers
PRODUCT_BUILD_PROP_OVERRIDES += \
    DEVICE_MAINTAINERS="Jeferson Oliveira (jro1979oliver)"

PRODUCT_OVERRIDE_INFO := true
PRODUCT_OVERRIDE_FINGERPRINT := motorola/victara_tmo/victara:5.1/LPE23.32-21.3/5:user/release-keys

